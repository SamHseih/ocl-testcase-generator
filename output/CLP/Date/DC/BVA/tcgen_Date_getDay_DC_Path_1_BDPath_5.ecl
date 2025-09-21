:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_1_BDPath_5(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)),
(((((((((Self_year #< 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_823914581),
delay_mod(Self_year,4, Var_1680503330),
delay_mod(Self_year,400, Var_2100440237),
((Var_2100440237 #= 0) ; ((Var_1680503330 #= 0) , (Var_823914581 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_566113173),
delay_mod(Self_year,4, Var_1330247343),
delay_mod(Self_year,100, Var_2017797638),
delay_mod(Self_year,4, Var_343812839),
delay_mod(Self_year,400, Var_1150058854),
((Var_1150058854 #\= 0) , (((Var_343812839 #\= 0) , (Var_2017797638 #\= 0)) ; ((Var_1330247343 #= 0) , (Var_566113173 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #> 1) , (Self_month #< 1)) , (Self_month #< 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_131872530),
delay_mod(Self_year,4, Var_795321555),
delay_mod(Self_year,400, Var_98826337),
((Var_98826337 #= 0) ; ((Var_795321555 #= 0) , (Var_131872530 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_800088638),
delay_mod(Self_year,4, Var_1236444285),
delay_mod(Self_year,100, Var_1541525668),
delay_mod(Self_year,4, Var_1096485705),
delay_mod(Self_year,400, Var_1834361038),
((Var_1834361038 #\= 0) , (((Var_1096485705 #\= 0) , (Var_1541525668 #\= 0)) ; ((Var_1236444285 #= 0) , (Var_800088638 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #> 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_304354378),
delay_mod(Self_year,4, Var_704106237),
delay_mod(Self_year,400, Var_1880078449),
((Var_1880078449 #= 0) ; ((Var_704106237 #= 0) , (Var_304354378 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_993370665),
delay_mod(Self_year,4, Var_159475521),
delay_mod(Self_year,100, Var_504807594),
delay_mod(Self_year,4, Var_332873513),
delay_mod(Self_year,400, Var_90567568),
((Var_90567568 #\= 0) , (((Var_332873513 #\= 0) , (Var_504807594 #\= 0)) ; ((Var_159475521 #= 0) , (Var_993370665 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_479920916),
delay_mod(Self_year,4, Var_1161322357),
delay_mod(Self_year,400, Var_1237912220),
((Var_1237912220 #= 0) ; ((Var_1161322357 #= 0) , (Var_479920916 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_757708014),
delay_mod(Self_year,4, Var_1777238524),
delay_mod(Self_year,100, Var_1848289347),
delay_mod(Self_year,4, Var_1865859824),
delay_mod(Self_year,400, Var_257459516),
((Var_257459516 #\= 0) , (((Var_1865859824 #\= 0) , (Var_1848289347 #\= 0)) ; ((Var_1777238524 #= 0) , (Var_757708014 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2038522556),
delay_mod(Self_year,4, Var_502848122),
delay_mod(Self_year,400, Var_596910004),
((Var_596910004 #= 0) ; ((Var_502848122 #= 0) , (Var_2038522556 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1954985045),
delay_mod(Self_year,4, Var_106999035),
delay_mod(Self_year,100, Var_1569754439),
delay_mod(Self_year,4, Var_1593458942),
delay_mod(Self_year,400, Var_530539368),
((Var_530539368 #\= 0) , (((Var_1593458942 #\= 0) , (Var_1569754439 #\= 0)) ; ((Var_106999035 #= 0) , (Var_1954985045 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
