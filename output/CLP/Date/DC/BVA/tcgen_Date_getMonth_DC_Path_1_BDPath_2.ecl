:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getMonth_DC_Path_1_BDPath_2(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1992550266),
delay_mod(Self_year,4, Var_2014461570),
delay_mod(Self_year,400, Var_1740846921),
((Var_1740846921 #= 0) ; ((Var_2014461570 #= 0) , (Var_1992550266 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_263885523),
delay_mod(Self_year,4, Var_1714113641),
delay_mod(Self_year,100, Var_262445056),
delay_mod(Self_year,4, Var_1898155970),
delay_mod(Self_year,400, Var_710190911),
((Var_710190911 #\= 0) , (((Var_1898155970 #\= 0) , (Var_262445056 #\= 0)) ; ((Var_1714113641 #= 0) , (Var_263885523 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2119891622),
delay_mod(Self_year,4, Var_1671507048),
delay_mod(Self_year,400, Var_687059528),
((Var_687059528 #= 0) ; ((Var_1671507048 #= 0) , (Var_2119891622 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_454305524),
delay_mod(Self_year,4, Var_850551034),
delay_mod(Self_year,100, Var_1478150312),
delay_mod(Self_year,4, Var_1833848849),
delay_mod(Self_year,400, Var_1473771722),
((Var_1473771722 #\= 0) , (((Var_1833848849 #\= 0) , (Var_1478150312 #\= 0)) ; ((Var_850551034 #= 0) , (Var_454305524 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1237825806),
delay_mod(Self_year,4, Var_282265585),
delay_mod(Self_year,400, Var_1297836716),
((Var_1297836716 #= 0) ; ((Var_282265585 #= 0) , (Var_1237825806 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1048855692),
delay_mod(Self_year,4, Var_1249875355),
delay_mod(Self_year,100, Var_1117519786),
delay_mod(Self_year,4, Var_1409545055),
delay_mod(Self_year,400, Var_1212116343),
((Var_1212116343 #\= 0) , (((Var_1409545055 #\= 0) , (Var_1117519786 #\= 0)) ; ((Var_1249875355 #= 0) , (Var_1048855692 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2051120548),
delay_mod(Self_year,4, Var_341138954),
delay_mod(Self_year,400, Var_1270038388),
((Var_1270038388 #= 0) ; ((Var_341138954 #= 0) , (Var_2051120548 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1973233403),
delay_mod(Self_year,4, Var_63387985),
delay_mod(Self_year,100, Var_1029472813),
delay_mod(Self_year,4, Var_1866875501),
delay_mod(Self_year,400, Var_1936722816),
((Var_1936722816 #\= 0) , (((Var_1866875501 #\= 0) , (Var_1029472813 #\= 0)) ; ((Var_63387985 #= 0) , (Var_1973233403 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_620557167),
delay_mod(Self_year,4, Var_285133380),
delay_mod(Self_year,400, Var_1068586139),
((Var_1068586139 #= 0) ; ((Var_285133380 #= 0) , (Var_620557167 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_245765246),
delay_mod(Self_year,4, Var_1292040526),
delay_mod(Self_year,100, Var_726181440),
delay_mod(Self_year,4, Var_510147134),
delay_mod(Self_year,400, Var_542365801),
((Var_542365801 #\= 0) , (((Var_510147134 #\= 0) , (Var_726181440 #\= 0)) ; ((Var_1292040526 #= 0) , (Var_245765246 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
