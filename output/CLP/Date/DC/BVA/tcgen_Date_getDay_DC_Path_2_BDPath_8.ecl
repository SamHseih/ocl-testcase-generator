:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_2_BDPath_8(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_746074699),
delay_mod(Self_year,4, Var_127791068),
delay_mod(Self_year,400, Var_405896924),
((Var_405896924 #= 0) ; ((Var_127791068 #= 0) , (Var_746074699 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1309335839),
delay_mod(Self_year,4, Var_596470015),
delay_mod(Self_year,100, Var_1267105885),
delay_mod(Self_year,4, Var_1481818223),
delay_mod(Self_year,400, Var_1095352419),
((Var_1095352419 #\= 0) , (((Var_1481818223 #\= 0) , (Var_1267105885 #\= 0)) ; ((Var_596470015 #= 0) , (Var_1309335839 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),
(Self_day #=< 31),
(Result #= Self_day),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
