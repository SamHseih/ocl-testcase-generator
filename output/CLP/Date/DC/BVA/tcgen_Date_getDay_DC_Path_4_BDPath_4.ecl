:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_4_BDPath_4(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2133344792),
delay_mod(Self_year,4, Var_1081769770),
delay_mod(Self_year,400, Var_1319483139),
((Var_1319483139 #= 0) ; ((Var_1081769770 #= 0) , (Var_2133344792 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_44559647),
delay_mod(Self_year,4, Var_1067599825),
delay_mod(Self_year,100, Var_749927456),
delay_mod(Self_year,4, Var_1330400026),
delay_mod(Self_year,400, Var_1916700921),
((Var_1916700921 #\= 0) , (((Var_1330400026 #\= 0) , (Var_749927456 #\= 0)) ; ((Var_1067599825 #= 0) , (Var_44559647 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_1594873248),
delay_mod(Self_year,4, Var_1692885405),
delay_mod(Self_year,400, Var_1230955136),
((Var_1230955136 #= 0) ; ((Var_1692885405 #= 0) , (Var_1594873248 #\= 0))),
(Self_day #=< 29),
(Result #= Self_day),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
