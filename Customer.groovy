import com.orangesignal.csv.annotation.CsvEntity
import com.orangesignal.csv.annotation.CsvColumn

@CsvEntity
public class Customer {
    @CsvColumn(name = "氏名")
    public String name

    @CsvColumn(name = "年齢")
    public Integer age
}
