:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DCC_Path_17_BDPath_6(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%CLG Path Constrints,
(Y #> 1),
(M #> 1),
(M #< 12),
(D #> 1),
(M #\= 1),
(M #\= 3),
(M #\= 5),
(M #\= 7),
(M #\= 8),
(M #\= 10),
(M #\= 12),
(M #\= 4),
(M #\= 6),
(M #\= 9),
(M #\= 11),
delay_mod(Y,400, Var_733943822),
(Var_733943822 #= 0),
(D #< 29),
(Self_year #= Y),
(Self_month #= M),
(Self_day #= D),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
