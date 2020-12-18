package com.wukaixun.gaoji.zijieliuhezifuliu.guandaoliu;

import java.io.*;

/**
 * 利用管道流实现多线程消息发送和接收
 *
 * @author wukaixun
 * @date 2020.11.19
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        SendThread send = new SendThread();
        ReceiveThread receive = new ReceiveThread();
        send.getOutput().connect(receive.getInput());
        new Thread(send).start();
        new Thread(receive).start();
    }
}

class SendThread implements Runnable {
    private PipedOutputStream output;

    public SendThread() {
        this.output = new PipedOutputStream();
    }

    @Override
    public void run() {
        for (int x = 0; x < 9; x++) {
            try {
                this.output.write(("第" + (x + 1) + "次发送: 哈哈哈哈哈\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            this.output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedOutputStream getOutput() {
        return output;
    }
}

class ReceiveThread implements Runnable {
    private PipedInputStream input;

    public ReceiveThread() {
        this.input = new PipedInputStream();
    }

    @Override
    public void run() {
        byte[] data = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            while ((len = this.input.read(data)) != -1) {
                bos.write(data, 0, len);
            }
            System.out.println("[消息接收]\n" + new String(bos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedInputStream getInput() {
        return input;
    }
}
