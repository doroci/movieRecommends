package wordCount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by lee on 2016. 6. 10..
 */
public class MyReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

    private LongWritable sumWritable = new LongWritable();

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {

        long sum = 0;
        for (LongWritable val : values){
            sum += val.get();
        }
        sumWritable.set(sum);
        context.write(key, sumWritable);

    }
}
