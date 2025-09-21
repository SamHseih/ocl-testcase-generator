:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_1_BDPath_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_865059288),
delay_mod(Self_year,4, Var_1193471756),
delay_mod(Self_year,400, Var_1222768327),
((Var_1222768327 #= 0) ; ((Var_1193471756 #= 0) , (Var_865059288 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1439394198),
delay_mod(Self_year,4, Var_403170294),
delay_mod(Self_year,100, Var_1208825205),
delay_mod(Self_year,4, Var_253601149),
delay_mod(Self_year,400, Var_26540753),
((Var_26540753 #\= 0) , (((Var_253601149 #\= 0) , (Var_1208825205 #\= 0)) ; ((Var_403170294 #= 0) , (Var_1439394198 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1603177117),
delay_mod(Self_year,4, Var_1464191502),
delay_mod(Self_year,400, Var_987249254),
((Var_987249254 #= 0) ; ((Var_1464191502 #= 0) , (Var_1603177117 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1020154737),
delay_mod(Self_year,4, Var_398457879),
delay_mod(Self_year,100, Var_1850954068),
delay_mod(Self_year,4, Var_363023858),
delay_mod(Self_year,400, Var_1530446316),
((Var_1530446316 #\= 0) , (((Var_363023858 #\= 0) , (Var_1850954068 #\= 0)) ; ((Var_398457879 #= 0) , (Var_1020154737 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_246273275),
delay_mod(Self_year,4, Var_1947185929),
delay_mod(Self_year,400, Var_2077742806),
((Var_2077742806 #= 0) ; ((Var_1947185929 #= 0) , (Var_246273275 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1139814130),
delay_mod(Self_year,4, Var_597307515),
delay_mod(Self_year,100, Var_713312506),
delay_mod(Self_year,4, Var_1864387098),
delay_mod(Self_year,400, Var_770010802),
((Var_770010802 #\= 0) , (((Var_1864387098 #\= 0) , (Var_713312506 #\= 0)) ; ((Var_597307515 #= 0) , (Var_1139814130 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2052910813),
delay_mod(Self_year,4, Var_1107412069),
delay_mod(Self_year,400, Var_1534694976),
((Var_1534694976 #= 0) ; ((Var_1107412069 #= 0) , (Var_2052910813 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1823541245),
delay_mod(Self_year,4, Var_1896232624),
delay_mod(Self_year,100, Var_1038677529),
delay_mod(Self_year,4, Var_716487794),
delay_mod(Self_year,400, Var_1314838582),
((Var_1314838582 #\= 0) , (((Var_716487794 #\= 0) , (Var_1038677529 #\= 0)) ; ((Var_1896232624 #= 0) , (Var_1823541245 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_116734858),
delay_mod(Self_year,4, Var_1551945522),
delay_mod(Self_year,400, Var_2106592975),
((Var_2106592975 #= 0) ; ((Var_1551945522 #= 0) , (Var_116734858 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1862383967),
delay_mod(Self_year,4, Var_1074263646),
delay_mod(Self_year,100, Var_438589491),
delay_mod(Self_year,4, Var_1732238286),
delay_mod(Self_year,400, Var_93740343),
((Var_93740343 #\= 0) , (((Var_1732238286 #\= 0) , (Var_438589491 #\= 0)) ; ((Var_1074263646 #= 0) , (Var_1862383967 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
