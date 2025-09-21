:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_1_BDPath_3(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #= 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_996796369),
delay_mod(Self_year,4, Var_135640095),
delay_mod(Self_year,400, Var_1430439149),
((Var_1430439149 #= 0) ; ((Var_135640095 #= 0) , (Var_996796369 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_359922172),
delay_mod(Self_year,4, Var_1632682988),
delay_mod(Self_year,100, Var_1153447573),
delay_mod(Self_year,4, Var_132577100),
delay_mod(Self_year,400, Var_231756373),
((Var_231756373 #\= 0) , (((Var_132577100 #\= 0) , (Var_1153447573 #\= 0)) ; ((Var_1632682988 #= 0) , (Var_359922172 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_587153993),
delay_mod(Self_year,4, Var_757004314),
delay_mod(Self_year,400, Var_1279271200),
((Var_1279271200 #= 0) ; ((Var_757004314 #= 0) , (Var_587153993 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_52908367),
delay_mod(Self_year,4, Var_1527953000),
delay_mod(Self_year,100, Var_18242360),
delay_mod(Self_year,4, Var_1276261147),
delay_mod(Self_year,400, Var_1971764991),
((Var_1971764991 #\= 0) , (((Var_1276261147 #\= 0) , (Var_18242360 #\= 0)) ; ((Var_1527953000 #= 0) , (Var_52908367 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1010953501),
delay_mod(Self_year,4, Var_1423561005),
delay_mod(Self_year,400, Var_943870983),
((Var_943870983 #= 0) ; ((Var_1423561005 #= 0) , (Var_1010953501 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1136419747),
delay_mod(Self_year,4, Var_1881561036),
delay_mod(Self_year,100, Var_1785507932),
delay_mod(Self_year,4, Var_1084502906),
delay_mod(Self_year,400, Var_1613095350),
((Var_1613095350 #\= 0) , (((Var_1084502906 #\= 0) , (Var_1785507932 #\= 0)) ; ((Var_1881561036 #= 0) , (Var_1136419747 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1011279482),
delay_mod(Self_year,4, Var_208866101),
delay_mod(Self_year,400, Var_543846639),
((Var_543846639 #= 0) ; ((Var_208866101 #= 0) , (Var_1011279482 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_690686166),
delay_mod(Self_year,4, Var_576020159),
delay_mod(Self_year,100, Var_921420643),
delay_mod(Self_year,4, Var_1165303897),
delay_mod(Self_year,400, Var_887750041),
((Var_887750041 #\= 0) , (((Var_1165303897 #\= 0) , (Var_921420643 #\= 0)) ; ((Var_576020159 #= 0) , (Var_690686166 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1534745514),
delay_mod(Self_year,4, Var_2003496028),
delay_mod(Self_year,400, Var_30578394),
((Var_30578394 #= 0) ; ((Var_2003496028 #= 0) , (Var_1534745514 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_2088371948),
delay_mod(Self_year,4, Var_1976870338),
delay_mod(Self_year,100, Var_1434234664),
delay_mod(Self_year,4, Var_1083021083),
delay_mod(Self_year,400, Var_1819063424),
((Var_1819063424 #\= 0) , (((Var_1083021083 #\= 0) , (Var_1434234664 #\= 0)) ; ((Var_1976870338 #= 0) , (Var_2088371948 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
