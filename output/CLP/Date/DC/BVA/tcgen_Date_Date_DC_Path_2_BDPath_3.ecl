:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DC_Path_2_BDPath_3(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day, Y, M, D]#::(-32768)..32767,
%CLG Path Constrints,
(((((Y #>= 1) , (M #>= 1)) , (M #= 12)) , (D #>= 1)) , (((((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),(D #=< 31));((((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),((((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),(D #=< 30));(((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),((delay_mod(Y,100, Var_1990160809),
delay_mod(Y,4, Var_1285524499),
delay_mod(Y,400, Var_1524960486),
((Var_1524960486 #= 0) ; ((Var_1285524499 #= 0) , (Var_1990160809 #\= 0))),(D #< 30));(delay_mod(Y,100, Var_117009527),
delay_mod(Y,4, Var_199640888),
delay_mod(Y,100, Var_1000975683),
delay_mod(Y,4, Var_1238959340),
delay_mod(Y,400, Var_76432244),
((Var_76432244 #\= 0) , (((Var_1238959340 #\= 0) , (Var_1000975683 #\= 0)) ; ((Var_199640888 #= 0) , (Var_117009527 #= 0)))),(D #< 29)))))))),
(((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),
(D #=< 31),
(((Self_year #= Y) , (Self_month #= M)) , (Self_day #= D)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
