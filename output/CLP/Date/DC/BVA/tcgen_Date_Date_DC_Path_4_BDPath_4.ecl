:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DC_Path_4_BDPath_4(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day, Y, M, D]#::(-32768)..32767,
%CLG Path Constrints,
(((((Y #>= 1) , (M #>= 1)) , (M #=< 12)) , (D #= 1)) , (((((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),(D #=< 31));((((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),((((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),(D #=< 30));(((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),((delay_mod(Y,100, Var_422396878),
delay_mod(Y,4, Var_1912962767),
delay_mod(Y,400, Var_452805835),
((Var_452805835 #= 0) ; ((Var_1912962767 #= 0) , (Var_422396878 #\= 0))),(D #< 30));(delay_mod(Y,100, Var_1769190683),
delay_mod(Y,4, Var_447981768),
delay_mod(Y,100, Var_1125736023),
delay_mod(Y,4, Var_858952163),
delay_mod(Y,400, Var_1201484275),
((Var_1201484275 #\= 0) , (((Var_858952163 #\= 0) , (Var_1125736023 #\= 0)) ; ((Var_447981768 #= 0) , (Var_1769190683 #= 0)))),(D #< 29)))))))),
(((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),
((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),
delay_mod(Y,100, Var_1089418272),
delay_mod(Y,4, Var_1233990028),
delay_mod(Y,400, Var_1847008471),
((Var_1847008471 #= 0) ; ((Var_1233990028 #= 0) , (Var_1089418272 #\= 0))),
(D #< 30),
(((Self_year #= Y) , (Self_month #= M)) , (Self_day #= D)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
