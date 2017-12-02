// https://mvnrepository.com/artifact/com.orangesignal/orangesignal-csv
@Grapes(
    @Grab(group='com.orangesignal', module='orangesignal-csv', version='2.2.1')
)
import com.orangesignal.csv.CsvConfig
import com.orangesignal.csv.manager.CsvEntityManager

println "入出力設定"
CsvConfig cfg = new CsvConfig();
cfg.setQuoteDisabled(false);
cfg.setEscapeDisabled(false);
cfg.setEscape('"' as char)
cfg.setIgnoreEmptyLines(true);
println "値の改行文字列を置換える文字列[${cfg.getBreakString()}], エスケープ文字[${cfg.getEscape()}], 無視する行の正規表現パターン群[${cfg.getIgnoreLinePatterns()}], データ出力時の改行文字列[${cfg.getLineSeparator()}], 値がないことを表す文字列[${cfg.getNullString()}], 囲み文字[${cfg.getQuote()}], 囲み文字出力方法の種類[${cfg.getQuotePolicy()}], 区切り文字[${cfg.getSeparator()}], ファイルの先頭から読飛ばす行数[${cfg.getSkipLines()}], エスケープ文字を無効にするかどうか[${cfg.isEscapeDisabled()}], 値がないことを表す文字列の大文字と小文字を区別するかどうか[${cfg.isIgnoreCaseNullString()}], 空行を無視するかどうか[${cfg.isIgnoreEmptyLines()}], 値より前のホワイトスペースを除去するかどうか[${cfg.isIgnoreLeadingWhitespaces()}], 値より後ろのホワイトスペースを除去するかどうか[${cfg.isIgnoreTrailingWhitespaces()}], 囲み文字を無効にするかどうか[${cfg.isQuoteDisabled()}], UTF-8 エンコーディングでの出力時に BOM (Byte Order Mark) を付与するかどうか[${cfg.isUtf8bomPolicy()}], 可変項目数を許可するかどうか[${cfg.isVariableColumns()}]"

println ""
println "入力"
List<Customer> customers = new CsvEntityManager().config(cfg).load(Customer.class).from(new File("input.csv"));
customers.eachWithIndex { record,i ->
    println "${i}行目----------"
    println "name[${record.name}]"
    println "age[${record.age}]"
}

println ""
println "出力"
new CsvEntityManager().config(cfg).save(customers, Customer.class).to(new File("output.csv"));
println "output.csv を確認して！"
