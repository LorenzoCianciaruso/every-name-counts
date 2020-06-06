package every.name.counts;

import com.amazonaws.services.textract.AmazonTextract;
import com.amazonaws.services.textract.AmazonTextractClientBuilder;
import com.amazonaws.services.textract.model.AnalyzeDocumentRequest;
import com.amazonaws.services.textract.model.AnalyzeDocumentResult;
import com.amazonaws.services.textract.model.Document;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class TextExtractor {

    public void extractText() {
        String document="archive_example.png";

        ByteBuffer imageBytes = null;
        try (InputStream inputStream = new FileInputStream(new File(getClass().getClassLoader().getResource(document).getFile()))) {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        AmazonTextract client = AmazonTextractClientBuilder.defaultClient();

        AnalyzeDocumentRequest analyzeDocumentRequest = new AnalyzeDocumentRequest().withDocument(new Document().withBytes(imageBytes)).withFeatureTypes("FORMS");

        AnalyzeDocumentResult analyzeDocumentResult = client.analyzeDocument(analyzeDocumentRequest);
        System.out.println(analyzeDocumentResult.toString());
    }
}
