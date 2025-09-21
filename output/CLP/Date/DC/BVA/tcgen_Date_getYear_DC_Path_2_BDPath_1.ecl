:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_2_BDPath_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_221634215),
delay_mod(Self_year,4, Var_2003891312),
delay_mod(Self_year,400, Var_1583159071),
((Var_1583159071 #= 0) ; ((Var_2003891312 #= 0) , (Var_221634215 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_607207372),
delay_mod(Self_year,4, Var_131206411),
delay_mod(Self_year,100, Var_2012330741),
delay_mod(Self_year,4, Var_1101184763),
delay_mod(Self_year,400, Var_1816147548),
((Var_1816147548 #\= 0) , (((Var_1101184763 #\= 0) , (Var_2012330741 #\= 0)) ; ((Var_131206411 #= 0) , (Var_607207372 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),
(Self_day #=< 31),
(Result #= Self_year),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
