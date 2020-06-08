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

public class Extractor {

    public List<Feature> extractText() {
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
                .map(it -> Feature.builder()
                            .text(it.getText())
                            .top(it.getGeometry().getBoundingBox().getTop())
                            .left(it.getGeometry().getBoundingBox().getLeft())
                            .height(it.getGeometry().getBoundingBox().getHeight())
                            .width(it.getGeometry().getBoundingBox().getWidth())
                        .build())
                .collect(Collectors.toList());
    }
}
