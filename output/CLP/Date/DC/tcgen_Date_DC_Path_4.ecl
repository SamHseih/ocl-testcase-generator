:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_DC_Path_4(Self):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%CLG Path Constrints,
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , true),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_1097324923),
delay_mod(Self_year,4, Var_351962798),
delay_mod(Self_year,100, Var_115433442),
delay_mod(Self_year,4, Var_1760670079),
delay_mod(Self_year,400, Var_388104475),
((Var_388104475 #\= 0) , (((Var_1760670079 #\= 0) , (Var_115433442 #\= 0)) ; ((Var_351962798 #= 0) , (Var_1097324923 #= 0)))),
(Self_day #=< 28),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
