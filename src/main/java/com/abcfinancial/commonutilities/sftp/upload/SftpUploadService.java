package com.abcfinancial.commonutilities.sftp.upload;

import com.abcfinancial.commonutilities.sftp.config.SftpConfig;
import com.abcfinancial.commonutilities.sftp.config.SftpConfigClient;
import com.abcfinancial.commonutilities.sftp.config.SftpDisconnect;
import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;
import java.util.Properties;
import java.util.ResourceBundle;

@Configuration
public class SftpUploadService extends SftpDisconnect implements SftpUpload
{

    private final static Logger logger = LoggerFactory.getLogger( SftpUploadService.class );
    private Session session = null;

    @Override
    public ChannelSftp connect( String server, int port, String login, String password )
    {
        return null;
    }
    @Override
    public void uploadFile( ChannelSftp channelSftp,String sourceFile, String destinationFile )
    {
        if( channelSftp == null || session == null || !session.isConnected() || ! channelSftp.isConnected() )
        {
            throw new RuntimeException( "Connection to server is closed. Open it first." );
        }

        try
        {
            logger.debug( "Uploading file to server" );
            channelSftp.put( sourceFile, destinationFile );
            logger.info( "Upload successfull." );
        }
        catch( SftpException e )
        {
            //throw new Exception( e );
        }
    }


}
