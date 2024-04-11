import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

class Data {
    private String type;
    private Object content;

    public Data(String type, Object content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}

abstract class DataProcessor {
    public abstract void createDataProcessor(Data data);
}

class TextDataProcessor extends DataProcessor {
    @Override
    public void createDataProcessor(Data data) {
        if (data.getType().equals("text")) {
            TextContent textContent = (TextContent) data.getContent();
            String text = textContent.getText();
            System.out.println("Processing text data: " + text);
        } else {
            System.out.println("Invalid data type for TextDataProcessor");
        }
    }
}

class AudioDataProcessor extends DataProcessor {
    @Override
    public void createDataProcessor(Data data) {
        if (data.getType().equals("audio")) {
            AudioContent audioContent = (AudioContent) data.getContent();
            byte[] audioData = audioContent.getAudioData();
            System.out.println("Processing audio data. Audio size: " + audioData.length + " bytes");
        } else {
            System.out.println("Invalid data type for AudioDataProcessor");
        }
    }
}


class VideoDataProcessor extends DataProcessor {
    @Override
    public void createDataProcessor(Data data) {
        if (data.getType().equals("video")) {
            VideoContent videoContent = (VideoContent) data.getContent();
            byte[] videoData = videoContent.getVideoData();
            System.out.println("Processing video data. Video size: " + videoData.length + " bytes");
        } else {
            System.out.println("Invalid data type for VideoDataProcessor");
        }
    }
}

class TextContent {
    private String text;

    public TextContent(String filePath) {
        this.text = readTextFromFile(filePath);
    }

    private String readTextFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading text file: " + e.getMessage());
        }
        return stringBuilder.toString();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

class AudioContent {
    private byte[] audioData;

    public AudioContent(String filePath) {
        this.audioData = readAudioFromFile(filePath);
    }

    private byte[] readAudioFromFile(String filePath) {
        try {
            return Files.readAllBytes(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("Error reading audio file: " + e.getMessage());
            return new byte[0];
        }
    }

    public byte[] getAudioData() {
        return audioData;
    }

    public void setAudioData(byte[] audioData) {
        this.audioData = audioData;
    }
}

class VideoContent {
    private byte[] videoData;

    public VideoContent(String filePath) {
        this.videoData = readVideoFromFile(filePath);
    }

    private byte[] readVideoFromFile(String filePath) {
        try {
            return Files.readAllBytes(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("Error reading video file: " + e.getMessage());
            return new byte[0];
        }
    }

    public byte[] getVideoData() {
        return videoData;
    }

    public void setVideoData(byte[] videoData) {
        this.videoData = videoData;
    }
}

class DataProcessorCreator {
    private DataProcessor processor;

    public void setProcessor(DataProcessor processor) {
        this.processor = processor;
    }

    public void processData(Data data) {
        if (processor != null) {
            processor.createDataProcessor(data);
        } else {
            System.out.println("No processor set");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Data textData = new Data("text", new TextContent("src/firdavs.txt"));
        Data videoData = new Data("video", new VideoContent("src/video.mp4"));
        Data audioData = new Data("audio", new AudioContent("src/audio.mp3"));

        DataProcessor textProcessor = new TextDataProcessor();
        DataProcessor videoProcessor = new VideoDataProcessor();
        DataProcessor audioProcessor = new AudioDataProcessor();

        DataProcessorCreator processorCreator = new DataProcessorCreator();

        processorCreator.setProcessor(textProcessor);
        System.out.println();
        processorCreator.processData(textData);

        processorCreator.setProcessor(videoProcessor);
        processorCreator.processData(videoData);
        System.out.println();

        processorCreator.setProcessor(audioProcessor);
        processorCreator.processData(audioData);
    }
}
