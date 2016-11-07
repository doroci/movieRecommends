package wordCount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.util.StringTokenizer;


/**
 * Created by lee on 2016. 6. 10..
 */
public class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {


    private final static LongWritable one = new LongWritable(1);
    private Text word = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line, "\t\r\n\f|,.()<>");
        while( tokenizer.hasMoreTokens()){

            word.set(tokenizer.nextToken().toLowerCase());
            context.write(word, one);
       }

    }
}
