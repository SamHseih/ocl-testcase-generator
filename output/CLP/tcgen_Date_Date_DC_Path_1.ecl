:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

tcgen_Date_Date_DC_Path_1(Y,M,D,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%CLG Path Constrints,
((((((Y #< 1) ; (Y #> 3999)) ; (M #< 1)) ; (M #> 12)) ; (D #< 1)) ; (((((((M #\= 1),
(M #\= 3)),
(M #\= 5)),
(M #\= 7)),
(M #\= 8)),
(M #\= 10)),
(M #\= 12))),
Result = 'Exception',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
