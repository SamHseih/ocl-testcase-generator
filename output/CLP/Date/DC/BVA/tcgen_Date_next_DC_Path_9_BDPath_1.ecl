:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_next_DC_Path_9_BDPath_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],Result = [Result_year,Result_month,Result_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(Self_month #\= 12),
((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_1741979653),
delay_mod(Self_year,4, Var_166794956),
delay_mod(Self_year,100, Var_306612792),
delay_mod(Self_year,4, Var_447212746),
delay_mod(Self_year,400, Var_1496355635),
((Var_1496355635 #\= 0) , (((Var_447212746 #\= 0) , (Var_306612792 #\= 0)) ; ((Var_166794956 #= 0) , (Var_1741979653 #= 0)))),
(Self_day #= 28),
(((Result_year #= Self_year) , (Result_month #= (Self_month+1))) , (Result_day #= 1)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
