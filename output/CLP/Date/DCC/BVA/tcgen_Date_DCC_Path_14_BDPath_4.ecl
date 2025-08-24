:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_DCC_Path_14_BDPath_4(Self):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%CLG Path Constrints,
(Self_year #>= 1),
(Self_month #>= 1),
(Self_month #=< 12),
(Self_day #= 1),
(Self_month #\= 1),
(Self_month #\= 3),
(Self_month #\= 5),
(Self_month #\= 7),
(Self_month #\= 8),
(Self_month #\= 10),
(Self_month #\= 12),
(Self_month #\= 4),
(Self_month #\= 6),
(Self_month #\= 9),
(Self_month #\= 11),
delay_mod(Self_year,400, Var_396283472),
(Var_396283472 #\= 0),
delay_mod(Self_year,4, Var_989892772),
(Var_989892772 #\= 0),
delay_mod(Self_year,100, Var_1020520290),
(Var_1020520290 #\= 0),
(Self_day #=< 28),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
