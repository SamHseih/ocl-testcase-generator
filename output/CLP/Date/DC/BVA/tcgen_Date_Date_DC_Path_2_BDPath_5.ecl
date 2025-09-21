:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DC_Path_2_BDPath_5(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day, Y, M, D]#::(-32768)..32767,
%CLG Path Constrints,
(((((Y #>= 1) , (M #>= 1)) , (M #=< 12)) , (D #>= 1)) , (((((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),(D #=< 31));((((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),((((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),(D #=< 30));(((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),((delay_mod(Y,100, Var_1043208434),
delay_mod(Y,4, Var_1192171522),
delay_mod(Y,400, Var_1661081225),
((Var_1661081225 #= 0) ; ((Var_1192171522 #= 0) , (Var_1043208434 #\= 0))),(D #< 30));(delay_mod(Y,100, Var_1882554559),
delay_mod(Y,4, Var_1049817027),
delay_mod(Y,100, Var_23211803),
delay_mod(Y,4, Var_1923598304),
delay_mod(Y,400, Var_776700275),
((Var_776700275 #\= 0) , (((Var_1923598304 #\= 0) , (Var_23211803 #\= 0)) ; ((Var_1049817027 #= 0) , (Var_1882554559 #= 0)))),(D #< 29)))))))),
(((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),
(D #= 31),
(((Self_year #= Y) , (Self_month #= M)) , (Self_day #= D)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
