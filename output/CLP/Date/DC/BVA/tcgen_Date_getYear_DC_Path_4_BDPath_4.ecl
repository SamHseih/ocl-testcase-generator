:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_4_BDPath_4(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1600667055),
delay_mod(Self_year,4, Var_2030036700),
delay_mod(Self_year,400, Var_137460818),
((Var_137460818 #= 0) ; ((Var_2030036700 #= 0) , (Var_1600667055 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1995619265),
delay_mod(Self_year,4, Var_1760126453),
delay_mod(Self_year,100, Var_1864869682),
delay_mod(Self_year,4, Var_1819776360),
delay_mod(Self_year,400, Var_255334292),
((Var_255334292 #\= 0) , (((Var_1819776360 #\= 0) , (Var_1864869682 #\= 0)) ; ((Var_1760126453 #= 0) , (Var_1995619265 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_752684363),
delay_mod(Self_year,4, Var_2123444693),
delay_mod(Self_year,400, Var_773662650),
((Var_773662650 #= 0) ; ((Var_2123444693 #= 0) , (Var_752684363 #\= 0))),
(Self_day #=< 29),
(Result #= Self_year),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
