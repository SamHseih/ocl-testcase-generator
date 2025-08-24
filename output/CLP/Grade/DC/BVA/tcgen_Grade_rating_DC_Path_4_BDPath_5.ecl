:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Grade_rating_DC_Path_4_BDPath_5(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_number],


%CLG Path Constrints,
((Self_number #> 0) , (Self_number #< 100)),
(Self_number #> 59),
(((Self_number #< 60) , (Self_number #< 69)) ; ((Self_number #> 60) , (Self_number #> 69))),
(((Self_number #< 70) , (Self_number #< 79)) ; ((Self_number #> 70) , (Self_number #> 79))),
((Self_number #> 80) , (Self_number #< 89)),
(Result = 'B'),

%TypeVar Labeling Parts
labeling_int([Self_number]).
