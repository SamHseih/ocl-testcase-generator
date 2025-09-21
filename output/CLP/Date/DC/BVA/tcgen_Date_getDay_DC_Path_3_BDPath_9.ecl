:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_3_BDPath_9(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1457263953),
delay_mod(Self_year,4, Var_271379554),
delay_mod(Self_year,400, Var_1962329560),
((Var_1962329560 #= 0) ; ((Var_271379554 #= 0) , (Var_1457263953 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_41489123),
delay_mod(Self_year,4, Var_884603232),
delay_mod(Self_year,100, Var_1124162665),
delay_mod(Self_year,4, Var_26970580),
delay_mod(Self_year,400, Var_1270836494),
((Var_1270836494 #\= 0) , (((Var_26970580 #\= 0) , (Var_1124162665 #\= 0)) ; ((Var_884603232 #= 0) , (Var_41489123 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),
(Self_day #= 30),
(Result #= Self_day),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
