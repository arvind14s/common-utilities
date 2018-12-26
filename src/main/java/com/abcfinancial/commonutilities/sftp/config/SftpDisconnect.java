package com.abcfinancial.commonutilities.sftp.config;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SftpDisconnect implements SftpConfig
{
    private final static Logger logger = LoggerFactory.getLogger( SftpConfigClient.class );


    private Session session = null;
    private Channel channel = null;

    public void disconnect(ChannelSftp channelSftp)
    {
        if( channelSftp != null )
        {
            logger.debug( "Disconnecting sftp channel" );
            channelSftp.disconnect();
        }
        if( channel != null )
        {
            logger.debug( "Disconnecting channel" );
            channel.disconnect();
        }
        if( session != null )
        {
            logger.debug( "Disconnecting session" );
            session.disconnect();
        }

    }
}
