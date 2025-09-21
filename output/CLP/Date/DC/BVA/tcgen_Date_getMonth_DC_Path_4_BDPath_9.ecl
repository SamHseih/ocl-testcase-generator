:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getMonth_DC_Path_4_BDPath_9(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_589273327),
delay_mod(Self_year,4, Var_2081652693),
delay_mod(Self_year,400, Var_406765571),
((Var_406765571 #= 0) ; ((Var_2081652693 #= 0) , (Var_589273327 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_2107443224),
delay_mod(Self_year,4, Var_572145572),
delay_mod(Self_year,100, Var_1158676965),
delay_mod(Self_year,4, Var_725680028),
delay_mod(Self_year,400, Var_1040776996),
((Var_1040776996 #\= 0) , (((Var_725680028 #\= 0) , (Var_1158676965 #\= 0)) ; ((Var_572145572 #= 0) , (Var_2107443224 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_1293680734),
delay_mod(Self_year,4, Var_138817329),
delay_mod(Self_year,400, Var_609656250),
((Var_609656250 #= 0) ; ((Var_138817329 #= 0) , (Var_1293680734 #\= 0))),
(Self_day #= 29),
(Result #= Self_month),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
