/**
 *
 *表示数值的字符串
 *数字的格式可以用A[.[B]][e|EC]或者.B[e|EC]表示，其中A和C都是
 *整数（可以有正负号，也可以没有），而B是一个无符号整数
 *
 *暂时存在问题
 */
public class NumericStrings {
	
	public boolean isNumeric(char[] str) {
        if (str == null)
            return false;
        boolean numeric = scanInteger(str);
        //如果出现了'.'则接下来是数字的小数部分
        int i = 0;
        if (str[i] == '.') {
            ++i;
            /*
            下面一行代码用||的原因：
            1.小数可以前面没有整数部分，例如.123等于0.123
            2.小数点后面可以没有数字，例如233.等于233.0
            3.小数点前面和后面可以有数字，例如233.666
             */
            numeric = scanUnsignedInteger(str) || numeric;
        }
        //如果出现'e'或'E'，接下来是数字的指数部分
        if (str[i] == 'e' || str[i] == 'E') {
            ++i;
            /*
            下面一行代码用&&的原因：
            1.当e或E前面没有数字时，整个字符串不能表示数字，例如.e1或e1
            2.当e或E后面没有整数时，整个字符串不能表示数字，例如12e或12e+5.4
             */
            numeric = numeric && scanInteger(str);
        }
        return numeric && i == str.length;
    }

    private boolean scanUnsignedInteger(char[] str) {
        int i = 0;
        while (i < str.length && str[i] >= '0' && str[i] <= '9')
            ++i;
        //若str中存在若干0-9的数字时，返回true
        return i > 0;
    }

    //整数的格式可以用+-B表示，其中B为无符号整数
    private boolean scanInteger(char[] str) {
        int i = 0;
        if (str[i] == '+' || str[i] == '-')
            ++i;
        return scanUnsignedInteger(str);
    }
}