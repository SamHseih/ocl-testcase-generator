:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DC_Path_3(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day, Y, M, D]#::(-32768)..32767,
%CLG Path Constrints,
(((((Y #>= 1) , (M #>= 1)) , (M #=< 12)) , (D #>= 1)) , (((((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),(D #=< 31));((((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),((((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),(D #=< 30));(((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),((delay_mod(Y,100, Var_1100767002),
delay_mod(Y,4, Var_313540687),
delay_mod(Y,400, Var_1990098664),
((Var_1990098664 #= 0) ; ((Var_313540687 #= 0) , (Var_1100767002 #\= 0))),(D #< 30));(delay_mod(Y,100, Var_2024453272),
delay_mod(Y,4, Var_98394724),
delay_mod(Y,100, Var_536765369),
delay_mod(Y,4, Var_1374026904),
delay_mod(Y,400, Var_2085002312),
((Var_2085002312 #\= 0) , (((Var_1374026904 #\= 0) , (Var_536765369 #\= 0)) ; ((Var_98394724 #= 0) , (Var_2024453272 #= 0)))),(D #< 29)))))))),
(((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),
((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),
(D #=< 30),
(((Self_year #= Y) , (Self_month #= M)) , (Self_day #= D)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
