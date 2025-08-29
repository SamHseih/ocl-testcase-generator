:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DC_Path_5(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day, Y, M, D]#::(-32768)..32767,
%CLG Path Constrints,
(((((Y #>= 1) , (M #>= 1)) , (M #=< 12)) , (D #>= 1)) , true),
(((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),
((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),
delay_mod(Y,100, Var_648786246),
delay_mod(Y,4, Var_120360571),
delay_mod(Y,100, Var_1710814638),
delay_mod(Y,4, Var_1125964210),
delay_mod(Y,400, Var_944140566),
((Var_944140566 #\= 0) , (((Var_1125964210 #\= 0) , (Var_1710814638 #\= 0)) ; ((Var_120360571 #= 0) , (Var_648786246 #= 0)))),
(D #< 29),
(((Self_year #= Y) , (Self_month #= M)) , (Self_day #= D)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
