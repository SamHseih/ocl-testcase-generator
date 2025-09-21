:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_2_BDPath_6(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1948810915),
delay_mod(Self_year,4, Var_2104973502),
delay_mod(Self_year,400, Var_735937428),
((Var_735937428 #= 0) ; ((Var_2104973502 #= 0) , (Var_1948810915 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1604247316),
delay_mod(Self_year,4, Var_1752461090),
delay_mod(Self_year,100, Var_788625466),
delay_mod(Self_year,4, Var_1753714541),
delay_mod(Self_year,400, Var_1095273238),
((Var_1095273238 #\= 0) , (((Var_1753714541 #\= 0) , (Var_788625466 #\= 0)) ; ((Var_1752461090 #= 0) , (Var_1604247316 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),
(Self_day #=< 31),
(Result #= Self_day),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
