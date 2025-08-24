:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DCC_Path_74_BDPath_3(Y,M,D,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day, Y, M, D]#::(-32768)..32767,
%CLG Path Constrints,
(Y #< 1),
(M #>= 1),
(M #=< 12),
(D #= 1),
(M #\= 1),
(M #\= 3),
(M #\= 5),
(M #\= 7),
(M #\= 8),
(M #\= 10),
(M #\= 12),
(M #= 6),
(D #=< 30),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
