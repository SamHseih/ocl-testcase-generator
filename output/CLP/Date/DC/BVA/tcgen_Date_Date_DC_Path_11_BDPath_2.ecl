:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DC_Path_11_BDPath_2(Y,M,D,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%CLG Path Constrints,
(((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),
((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),
(M #= 2),
delay_mod(Y,100, Var_2136288211),
delay_mod(Y,4, Var_1008925772),
delay_mod(Y,400, Var_1175259735),
((Var_1175259735 #\= 0) , ((Var_1008925772 #\= 0) ; (Var_2136288211 #= 0))),
(D #> 29),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
