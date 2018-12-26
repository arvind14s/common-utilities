package com.abcfinancial.commonutilities.sftp.config;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.Properties;

public class SftpConfigClient implements SftpConfig
{

    private final static Logger logger = LoggerFactory.getLogger( SftpConfigClient.class );


    private JSch jsch = null;
    private Session session = null;
    private Channel channel = null;
    private ChannelSftp channelSftp = null;



    /**
     * Connects to the server and does some commands.
     */
    public ChannelSftp connect(String server, int port, String login, String password )
    {
        try
        {
            logger.debug( "Initializing..." );
            jsch = new JSch();
            session = jsch.getSession( login, server, port );

            session.setPassword( password.getBytes( Charset.forName( "ISO-8859-1" ) ) );

            logger.debug( "Jsch set to StrictHostKeyChecking=no" );
            Properties config = new Properties();
            config.put( "StrictHostKeyChecking", "no" );
            session.setConfig( config );

            logger.info( "Connecting to " + server + ":" + port );
            session.connect();
            logger.info( "Connected !" );

            // Initializing a channel
            logger.debug( "Opening a channel ..." );
            channel = session.openChannel( "sftp" );
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            logger.debug( "Channel sftp opened" );

        }
        catch( JSchException e )
        {
            logger.error( "", e );
        }
        return channelSftp;

    }

    public void disconnect(ChannelSftp channelSftp)
    {
        if( channelSftp != null )
        {
            logger.debug( "Disconnecting sftp channel" );
            channelSftp.disconnect();
        }
       /* if( channel != null )
        {
            logger.debug( "Disconnecting channel" );
            channel.disconnect();
        }
        if( session != null )
        {
            logger.debug( "Disconnecting session" );
            session.disconnect();
        }*/

    }
}