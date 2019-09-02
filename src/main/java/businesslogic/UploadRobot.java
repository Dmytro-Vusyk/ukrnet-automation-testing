package businesslogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * This class include methods, which simulate user actions to attach the file
 */
public class UploadRobot {
    private static final Logger logger = LoggerFactory.getLogger(UploadRobot.class);

    public UploadRobot() {
    }

    /**
     * This method simulate user actions on desktop UI to chose and upload file to mail
     *
     * @param filePath path to file which will be uploaded
     */
    public void uploadFileWithRobot(String filePath) {
        File file = new File(filePath);
        logger.info("Setup ui");
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot robot = null;

        try {
            logger.info("Creating robot");
            robot = new Robot();
        } catch (AWTException e) {
            logger.info("Robot isn't created");
            e.printStackTrace();
        }
        logger.info("press CMD+TAB");
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(500);
        logger.info("Open GOTO Window");
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);
        logger.info("Pasting Clipboard value");
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(500);
        logger.info("Press Enter. Close GOTO Window");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
        logger.info("Press Enter. Close File selection Window");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
    }
}
