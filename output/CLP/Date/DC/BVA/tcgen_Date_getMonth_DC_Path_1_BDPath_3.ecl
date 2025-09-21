:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getMonth_DC_Path_1_BDPath_3(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #= 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1912960603),
delay_mod(Self_year,4, Var_1201173334),
delay_mod(Self_year,400, Var_586127428),
((Var_586127428 #= 0) ; ((Var_1201173334 #= 0) , (Var_1912960603 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1652807864),
delay_mod(Self_year,4, Var_997055773),
delay_mod(Self_year,100, Var_1063980005),
delay_mod(Self_year,4, Var_1628998132),
delay_mod(Self_year,400, Var_497208183),
((Var_497208183 #\= 0) , (((Var_1628998132 #\= 0) , (Var_1063980005 #\= 0)) ; ((Var_997055773 #= 0) , (Var_1652807864 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2146338580),
delay_mod(Self_year,4, Var_1110031167),
delay_mod(Self_year,400, Var_1456339771),
((Var_1456339771 #= 0) ; ((Var_1110031167 #= 0) , (Var_2146338580 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_730923082),
delay_mod(Self_year,4, Var_550302731),
delay_mod(Self_year,100, Var_800281454),
delay_mod(Self_year,4, Var_379478400),
delay_mod(Self_year,400, Var_900636745),
((Var_900636745 #\= 0) , (((Var_379478400 #\= 0) , (Var_800281454 #\= 0)) ; ((Var_550302731 #= 0) , (Var_730923082 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1292838001),
delay_mod(Self_year,4, Var_1899223686),
delay_mod(Self_year,400, Var_842179210),
((Var_842179210 #= 0) ; ((Var_1899223686 #= 0) , (Var_1292838001 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1944201789),
delay_mod(Self_year,4, Var_1207608476),
delay_mod(Self_year,100, Var_686989583),
delay_mod(Self_year,4, Var_259219561),
delay_mod(Self_year,400, Var_1839337592),
((Var_1839337592 #\= 0) , (((Var_259219561 #\= 0) , (Var_686989583 #\= 0)) ; ((Var_1207608476 #= 0) , (Var_1944201789 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1006227006),
delay_mod(Self_year,4, Var_375457936),
delay_mod(Self_year,400, Var_1910438136),
((Var_1910438136 #= 0) ; ((Var_375457936 #= 0) , (Var_1006227006 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_943454742),
delay_mod(Self_year,4, Var_1296456465),
delay_mod(Self_year,100, Var_1409154977),
delay_mod(Self_year,4, Var_1432536094),
delay_mod(Self_year,400, Var_854487022),
((Var_854487022 #\= 0) , (((Var_1432536094 #\= 0) , (Var_1409154977 #\= 0)) ; ((Var_1296456465 #= 0) , (Var_943454742 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_379645464),
delay_mod(Self_year,4, Var_1030684756),
delay_mod(Self_year,400, Var_1348453796),
((Var_1348453796 #= 0) ; ((Var_1030684756 #= 0) , (Var_379645464 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1606286799),
delay_mod(Self_year,4, Var_1325144078),
delay_mod(Self_year,100, Var_198499365),
delay_mod(Self_year,4, Var_621300254),
delay_mod(Self_year,400, Var_359368949),
((Var_359368949 #\= 0) , (((Var_621300254 #\= 0) , (Var_198499365 #\= 0)) ; ((Var_1325144078 #= 0) , (Var_1606286799 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
