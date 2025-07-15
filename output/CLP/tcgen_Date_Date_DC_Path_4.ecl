:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

tcgen_Date_Date_DC_Path_4(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%CLG Path Constrints,
((((((Self_year #>= 1),
(Self_year #=< 3999)),
(Self_month #>= 1)),
(Self_month #=< 12)),
(Self_day #=< 31)),
(Self_day #>= 1)),
((((((Y #>= 1),
(Y #=< 3999)),
(M #>= 1)),
(M #=< 12)),
(D #>= 1))),
(((((((M #\= 1),
(M #\= 3)),
(M #\= 5)),
(M #\= 7)),
(M #\= 8)),
(M #\= 10)),
(M #\= 12)),
((((M #\= 4),
(M #\= 6)),
(M #\= 9)),
(M #\= 11)),
delay_mod(Y,100, Var_2013559698),
delay_mod(Y,4, Var_2025269734),
delay_mod(Y,400, Var_1800031768),
(((Var_1800031768 #= 0) ; (Var_2025269734 #= 0)),
(Var_2013559698 #\= 0)),
(D #=< 29),
(((Self_year #= Y),
(Self_month #= M)),
(Self_day #= D)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
