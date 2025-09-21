:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_2_BDPath_8(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1886491834),
delay_mod(Self_year,4, Var_294658058),
delay_mod(Self_year,400, Var_1781493632),
((Var_1781493632 #= 0) ; ((Var_294658058 #= 0) , (Var_1886491834 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1169474473),
delay_mod(Self_year,4, Var_966544353),
delay_mod(Self_year,100, Var_689745064),
delay_mod(Self_year,4, Var_945722724),
delay_mod(Self_year,400, Var_1536471117),
((Var_1536471117 #\= 0) , (((Var_945722724 #\= 0) , (Var_689745064 #\= 0)) ; ((Var_966544353 #= 0) , (Var_1169474473 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),
(Self_day #=< 31),
(Result #= Self_year),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
