package every.name.counts;

import com.amazonaws.services.textract.AmazonTextract;
import com.amazonaws.services.textract.AmazonTextractClientBuilder;
import com.amazonaws.services.textract.model.*;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.stream.Collectors;

public class TextExtractor {

    public List<String> extractText() {
        String document="archive_example.png";

        ByteBuffer imageBytes = null;
        try (InputStream inputStream = new FileInputStream(new File(getClass().getClassLoader().getResource(document).getFile()))) {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        AmazonTextract client = AmazonTextractClientBuilder.defaultClient();

        DetectDocumentTextRequest detectDocumentTextRequest = new DetectDocumentTextRequest().withDocument(new Document().withBytes(imageBytes));

        DetectDocumentTextResult detectDocumentTextResult = client.detectDocumentText(detectDocumentTextRequest);
        return detectDocumentTextResult.getBlocks().stream()
                .filter(it -> it.getBlockType().equals("LINE"))
                .map(Block::getText)
                .collect(Collectors.toList());
    }
}
