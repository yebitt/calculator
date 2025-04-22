package lv3;

public enum OperatorType {
    PLUS('+'), SUBTRACTION('-'), MULTIPLICATION('x'), DIVISION('/');

    private char operator;

    OperatorType(char operator){
        this.operator = operator;
    }

    public static OperatorType find(char operator){
        for(OperatorType operatorType : OperatorType.values()){
            if(operatorType.operator == operator){
                return operatorType;
            }
        }
        throw new IllegalArgumentException("잘못된 수식");
    }

}
