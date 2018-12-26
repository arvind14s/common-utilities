package com.abcfinancial.commonutilities.sftp.config;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public interface SftpConfig
{
    ChannelSftp connect(String server, int port, String login, String password );
    void disconnect(ChannelSftp channelSftp);
}
