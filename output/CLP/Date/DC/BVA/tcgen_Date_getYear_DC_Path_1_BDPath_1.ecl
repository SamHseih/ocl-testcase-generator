:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_1_BDPath_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_447718425),
delay_mod(Self_year,4, Var_1206569586),
delay_mod(Self_year,400, Var_1427381743),
((Var_1427381743 #= 0) ; ((Var_1206569586 #= 0) , (Var_447718425 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1427646530),
delay_mod(Self_year,4, Var_846254484),
delay_mod(Self_year,100, Var_592983282),
delay_mod(Self_year,4, Var_1448525331),
delay_mod(Self_year,400, Var_1108924067),
((Var_1108924067 #\= 0) , (((Var_1448525331 #\= 0) , (Var_592983282 #\= 0)) ; ((Var_846254484 #= 0) , (Var_1427646530 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2088445230),
delay_mod(Self_year,4, Var_1297978429),
delay_mod(Self_year,400, Var_915349526),
((Var_915349526 #= 0) ; ((Var_1297978429 #= 0) , (Var_2088445230 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1280851663),
delay_mod(Self_year,4, Var_1764696127),
delay_mod(Self_year,100, Var_1223867739),
delay_mod(Self_year,4, Var_129153987),
delay_mod(Self_year,400, Var_168907708),
((Var_168907708 #\= 0) , (((Var_129153987 #\= 0) , (Var_1223867739 #\= 0)) ; ((Var_1764696127 #= 0) , (Var_1280851663 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_825249556),
delay_mod(Self_year,4, Var_883151184),
delay_mod(Self_year,400, Var_709865851),
((Var_709865851 #= 0) ; ((Var_883151184 #= 0) , (Var_825249556 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1550207152),
delay_mod(Self_year,4, Var_1864230087),
delay_mod(Self_year,100, Var_1168019749),
delay_mod(Self_year,4, Var_311239812),
delay_mod(Self_year,400, Var_2093010349),
((Var_2093010349 #\= 0) , (((Var_311239812 #\= 0) , (Var_1168019749 #\= 0)) ; ((Var_1864230087 #= 0) , (Var_1550207152 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1278677872),
delay_mod(Self_year,4, Var_341796579),
delay_mod(Self_year,400, Var_807657332),
((Var_807657332 #= 0) ; ((Var_341796579 #= 0) , (Var_1278677872 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_825936265),
delay_mod(Self_year,4, Var_1164107853),
delay_mod(Self_year,100, Var_711327356),
delay_mod(Self_year,4, Var_68377659),
delay_mod(Self_year,400, Var_1661123505),
((Var_1661123505 #\= 0) , (((Var_68377659 #\= 0) , (Var_711327356 #\= 0)) ; ((Var_1164107853 #= 0) , (Var_825936265 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1239759990),
delay_mod(Self_year,4, Var_891093184),
delay_mod(Self_year,400, Var_708533063),
((Var_708533063 #= 0) ; ((Var_891093184 #= 0) , (Var_1239759990 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1438030319),
delay_mod(Self_year,4, Var_902830499),
delay_mod(Self_year,100, Var_1754662105),
delay_mod(Self_year,4, Var_403147759),
delay_mod(Self_year,400, Var_2040467681),
((Var_2040467681 #\= 0) , (((Var_403147759 #\= 0) , (Var_1754662105 #\= 0)) ; ((Var_902830499 #= 0) , (Var_1438030319 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
