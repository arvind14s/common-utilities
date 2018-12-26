package com.abcfinancial.commonutilities.sftp.download;


import com.abcfinancial.commonutilities.sftp.config.SftpDisconnect;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SftpDownloadService extends SftpDisconnect implements SftpDownload
{
    private final static Logger logger = LoggerFactory.getLogger( SftpDownloadService.class );

    public void downloadFile( ChannelSftp channelSftp,String sourceFile, String destinationFile ) //throws Exception
    {
        if( channelSftp == null  || ! channelSftp.isConnected() )
        {
            throw new RuntimeException( "Connection to server is closed. Open it first." );
        }

        try
        {
            logger.debug( "Downloading file to server" );
            channelSftp.get( sourceFile, destinationFile );
            logger.info( "Download successfull." );
        }
        catch( SftpException e )
        {
            //throw new Exception( e.getMessage(), e );
        }
    }

    @Override
    public ChannelSftp connect( String server, int port, String login, String password )
    {
        return null;
    }
}
