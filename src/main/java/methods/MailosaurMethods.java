package methods;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import mailTests.Mailosaur;
import org.testng.Assert;

import java.io.IOException;

public class MailosaurMethods {

    public void mailosaurTest(String apiKey, String serverId, String serverDomain) throws MailosaurException, IOException {
        MailosaurClient mailosaur = new MailosaurClient(apiKey);
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo(serverDomain);
        Message message = mailosaur.messages().get(params, criteria);
        Assert.assertNotNull(message);
    }

}
