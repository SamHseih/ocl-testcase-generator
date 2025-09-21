package ccu.pllab.tcgen3.core.testscriptgen;

public record StringBlockRecord(String displayName, // ex: "next - 1_1"
    String methodName, // ex: "next"
    String pathId, // ex: "1_1"
    String selfDecl, // ex: "new Date(1,12,31);"
    String argdecl, // ex: "new Matrix(Arg_1)"
    String arryobjdecl, // ex. "int[][] Arg_1 = {{1,2}{2,3}};"
    String callStmt, // ex: "self.next();"
    String expectedDecl, // ex: "int[] expect = {1,2,3}"
    String assertion, // ex: "assertArrayEquals(expected, actual);"
    boolean isThrows, // ¬O§_ assertThrows
    String lambdaCall, // ¨Ò¥~ case: "new Date(-1, -1, -1)"
    String exceptionClass // ex: "Date.DateErrorException"
) {

}
