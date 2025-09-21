:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DC_Path_2_BDPath_6(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day, Y, M, D]#::(-32768)..32767,
%CLG Path Constrints,
(((((Y #> 1) , (M #> 1)) , (M #< 12)) , (D #> 1)) , (((((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),(D #=< 31));((((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),((((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),(D #=< 30));(((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),((delay_mod(Y,100, Var_118394766),
delay_mod(Y,4, Var_386163331),
delay_mod(Y,400, Var_1540374340),
((Var_1540374340 #= 0) ; ((Var_386163331 #= 0) , (Var_118394766 #\= 0))),(D #< 30));(delay_mod(Y,100, Var_694316372),
delay_mod(Y,4, Var_1516500233),
delay_mod(Y,100, Var_1850180796),
delay_mod(Y,4, Var_884452399),
delay_mod(Y,400, Var_235237152),
((Var_235237152 #\= 0) , (((Var_884452399 #\= 0) , (Var_1850180796 #\= 0)) ; ((Var_1516500233 #= 0) , (Var_694316372 #= 0)))),(D #< 29)))))))),
(((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),
(D #< 31),
(((Self_year #= Y) , (Self_month #= M)) , (Self_day #= D)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
