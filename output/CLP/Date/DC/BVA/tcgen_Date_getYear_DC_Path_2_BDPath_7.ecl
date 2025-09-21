:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_2_BDPath_7(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #= 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1487500813),
delay_mod(Self_year,4, Var_1911152052),
delay_mod(Self_year,400, Var_961409111),
((Var_961409111 #= 0) ; ((Var_1911152052 #= 0) , (Var_1487500813 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1231156911),
delay_mod(Self_year,4, Var_1525409936),
delay_mod(Self_year,100, Var_1708169732),
delay_mod(Self_year,4, Var_868815265),
delay_mod(Self_year,400, Var_1977310713),
((Var_1977310713 #\= 0) , (((Var_868815265 #\= 0) , (Var_1708169732 #\= 0)) ; ((Var_1525409936 #= 0) , (Var_1231156911 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),
(Self_day #=< 31),
(Result #= Self_year),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
