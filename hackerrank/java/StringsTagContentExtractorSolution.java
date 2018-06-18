import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsTagContentExtractorSolution {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("<[^>]+>");
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        while (testCases > 0) {
            String line = in.nextLine();
            Matcher m = p.matcher(line);

            String previousTag = null;
            int contentStartIndex = 0;
            int contentEndIndex = 0;
            boolean validContentFound = false;

            while (m.find()) {
                String currentTag = m.group();
                // System.out.printf("%s-%s-%d-%d%n", currentTag, previousTag, m.start(), m.end());

                if (isValidEndTag(previousTag, currentTag)) {
                    contentEndIndex = m.start();
                } else {
                    contentStartIndex = m.end();
                }
                previousTag = currentTag;

                if (contentStartIndex > 0
                        && contentEndIndex > 0) {
                    // System.out.println("content indexes=" + contentStartIndex + "," + contentEndIndex);
                    String content = line.substring(contentStartIndex, contentEndIndex);
                    if (!content.isEmpty()) {
                        System.out.println(content);
                        validContentFound = true;
                    }
                    contentStartIndex = 0;
                    contentEndIndex = 0;
                }
            }
            if (!validContentFound) {
                System.out.println("None");
            }
            testCases--;
        }
    }

    private static boolean isValidEndTag(String startTag, String endTag) {
        if (startTag == null) {
            return false;
        }
        return startTag.replaceFirst("<", "")
                .equals(endTag.replaceFirst("</", ""));
    }

/* Testcase 1
INPUT:
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crash</SA premium>

OUTPUT:
Nayeem loves counseling
Sanjay has no watch
None
Imtiaz has a secret crash
 */

/* Testcase 2
INPUT:
10
<h1>some</h1>
<h1>had<h1>public</h1></h1>
<h1>had<h1>public</h1515></h1>
<h1><h1></h1></h1>
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>
<>hello</>
<>hello</><h>dim</h>
<>hello</><h>dim</h>>>>>

OUTPUT:
some
public
None
None
None
None
None
None
dim
dim

some
public
None

None
None
None
hello
hello
dim
hello
dim
*/

    /* Testcase 3


     */
}