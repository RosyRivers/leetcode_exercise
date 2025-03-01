import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NettyServer {
    public static void main(String[] args) {
    //这里我们使用NioEventLoopGroup实现类即可，创建BossGroup和WorkerGroup
    //当然还有EpollEventLoopGroup，但是仅支持Linux，这是Netty基于Linux底层Epoll单独编写的一套本地实现，没有使用NIO那套
    EventLoopGroup bossGroup = new NioEventLoopGroup(), workerGroup = new NioEventLoopGroup();

    //创建服务端启动引导类
    ServerBootstrap bootstrap = new ServerBootstrap();
    //可链式，就很棒
    bootstrap
            .group(bossGroup, workerGroup)   //指定事件循环组
            .channel(NioServerSocketChannel.class)   //指定为NIO的ServerSocketChannel
            .childHandler(new ChannelInitializer<SocketChannel>() {   //注意，这里的SocketChannel不是我们NIO里面的，是Netty的
                @Override
                protected void initChannel(SocketChannel channel) {
                    //获取流水线，当我们需要处理客户端的数据时，实际上是像流水线一样在处理，这个流水线上可以有很多Handler
                    channel.pipeline().addLast(new ChannelInboundHandlerAdapter(){   //添加一个Handler，这里使用ChannelInboundHandlerAdapter
                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) {  //ctx是上下文，msg是收到的消息，默认以ByteBuf形式（也可以是其他形式，后面再说）
                            ByteBuf buf = (ByteBuf) msg;   //类型转换一下
                            System.out.println(Thread.currentThread().getName()+" >> 接收到客户端发送的数据："+buf.toString(StandardCharsets.UTF_8));
                            //通过上下文可以直接发送数据回去，注意要writeAndFlush才能让客户端立即收到
                            ctx.writeAndFlush(Unpooled.wrappedBuffer("已收到！".getBytes()));
                        }
                    });
                }
            });
    //最后绑定端口，启动
    bootstrap.bind(8080);
    }
    
    public static void client(String[] args) {
    //创建一个新的SocketChannel，一会通过通道进行通信
    try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
         Scanner scanner = new Scanner(System.in)){
        System.out.println("已连接到服务端！");
        while (true) {   //咱给它套个无限循环，这样就能一直发消息了
            System.out.println("请输入要发送给服务端的内容：");
            String text = scanner.nextLine();
            if(text.isEmpty()) continue;
            //直接向通道中写入数据，真舒服
            channel.write(ByteBuffer.wrap(text.getBytes()));
            System.out.println("已发送！");
            ByteBuffer buffer = ByteBuffer.allocate(128);
            channel.read(buffer);   //直接从通道中读取数据
            buffer.flip();
            System.out.println("收到服务器返回："+new String(buffer.array(), 0, buffer.remaining()));
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
}
