package util;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import util.EmptyStringException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;

@Component
public class FileUploadUtil {
	
	private static File videoFile;
	public static final Logger logger = LogManager.getLogger(FileUploadUtil.class);

	private static final String[] SUPPORTED_FORMATS = {
	        ".mp4", ".mov", ".avi", ".wmv", ".flv", ".mkv", ".webm"
	    };

	    /**
	     * Uploads a video file to the specified platform.
	     *
	     * @param filePath   the path of the video file to upload
	     * @throws IOException if an I/O error occurs
	     * @throws IllegalArgumentException if the video format is not supported
	     * @throws EmptyStringException if the filepath is not found or empty
	     */
	
	public static void uploadFile(String filePath) throws EmptyStringException{
		
		if(filePath.isBlank() || filePath.isEmpty()) { //if the filepath is blank or empty
			throw new EmptyStringException();			//throw an empty string exception
		}else {											// else
			File videoFileTemp = new File(filePath);				//create a new file from the file path and assign it to class object
			logger.info("File was found!, checking format");				//log that the file was found
			String fileExt = getFileExtension(videoFile);              //get the file extension and set it to a string
			if(isSupportedFormat(fileExt)) {                          //check if the extension is supported and if true,
				videoFile = videoFileTemp;							//set Tempfile to classFile object for class injection
			} else {												//if not compatibable
				throw new IllegalArgumentException(); 				//throw a exception
			}
		}
	}
	
	private static boolean isSupportedFormat(String extension) {    //Checks if file is correct format
        for (String format : SUPPORTED_FORMATS) {
            if (format.equalsIgnoreCase(extension)) {
                return true;
            }
        }
        return false;
    }
	
	 private static String getFileExtension(File file) {					//gets file extension from file name
	        String name = file.getName();
	        return name.substring(name.lastIndexOf('.')).toLowerCase();
	    }
	 
	 public static File getVideoFile() {							//public get method for other classes to dependecy inject
		 if(videoFile.exists()) {
			 return videoFile;
		 } else {
			 logger.warn("Video File does not exist");
		 }
		return videoFile;
		 
	 }
}
