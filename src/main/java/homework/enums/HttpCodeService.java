package homework.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Evgeny Borisov
 */
public class HttpCodeService {


    public void processHttp(String text) {
        //todo dgasfdjgsafd  httpcode: 404   sjdghfkjdshgafsdah

        Matcher matcher = Pattern.compile("httpcode:\\s*(\\d)").matcher(text);
        if (matcher.find()){
            int extractedCode = Integer.parseInt(matcher.group(1));
            for(HttpCode code: HttpCode.values()){
                if(code.startNumber == extractedCode){
                    code.process();
                }
            }
        }
    }

    public static void main(String[] args) {
        HttpCodeService httpCodeService = new HttpCodeService();
        httpCodeService.processHttp("dgasfdjgsafd  httpcode: 404   sjdghfkjdshgafsdah");
    }
}
